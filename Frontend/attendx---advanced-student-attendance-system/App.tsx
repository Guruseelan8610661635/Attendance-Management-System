
import React, { useState, useEffect } from 'react';
import { HashRouter as Router, Routes, Route, Navigate, useLocation } from 'react-router-dom';
import LoginPage from './pages/LoginPage';
import Dashboard from './pages/Dashboard';
import StudentManagement from './pages/StudentManagement';
import AttendanceMarking from './pages/AttendanceMarking';
import Reports from './pages/Reports';
import AdminSettings from './pages/AdminSettings';
import TimetableManagement from './pages/TimetableManagement';
import Sidebar from './components/Sidebar';
import Header from './components/Header';
import { User, UserRole } from './types';
import { MOCK_ADMIN, MOCK_STAFF } from './constants';

const AppContent: React.FC = () => {
  const [user, setUser] = useState<User | null>(null);
  const location = useLocation();
  const isLoginPage = location.pathname === '/login';

  useEffect(() => {
    if (user) {
      (window as any).currentUserRole = user.role;
      (window as any).currentUser = user;
    }
  }, [user]);

  const login = (role: UserRole, email?: string) => {
    if (role === UserRole.ADMIN) {
      setUser(MOCK_ADMIN);
    } else if (role === UserRole.STAFF) {
      const staffUser = MOCK_STAFF.find(s => s.email === email) || MOCK_STAFF[0];
      setUser(staffUser);
    } else {
      setUser({ 
        id: 's_1',
        name: 'Alex Rivera',
        email: 'alex@attendx.edu',
        role: UserRole.STUDENT,
        avatar: 'https://picsum.photos/seed/alex/200'
      });
    }
  };

  const logout = () => {
    setUser(null);
    (window as any).currentUserRole = undefined;
    (window as any).currentUser = undefined;
  };

  if (!user && !isLoginPage) {
    return <Navigate to="/login" replace />;
  }

  if (user && isLoginPage) {
    return <Navigate to="/dashboard" replace />;
  }

  return (
    <div className="flex h-screen bg-slate-50 overflow-hidden font-sans">
      {!isLoginPage && user && <Sidebar user={user} logout={logout} />}
      
      <div className="flex-1 flex flex-col overflow-hidden relative">
        {!isLoginPage && user && <Header user={user} />}
        
        <main className="flex-1 overflow-y-auto p-4 md:p-8">
          <Routes>
            <Route path="/login" element={<LoginPage onLogin={login} />} />
            <Route path="/dashboard" element={<Dashboard />} />
            <Route path="/students" element={<StudentManagement userRole={user?.role} />} />
            <Route path="/attendance" element={<AttendanceMarking />} />
            <Route path="/reports" element={<Reports />} />
            <Route path="/settings" element={<AdminSettings />} />
            <Route path="/timetable" element={<TimetableManagement />} />
            <Route path="/" element={<Navigate to={user ? "/dashboard" : "/login"} replace />} />
          </Routes>
        </main>
      </div>
    </div>
  );
};

const App: React.FC = () => {
  return (
    <Router>
      <AppContent />
    </Router>
  );
};

export default App;

import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import RegInstructuion from './reg-instructuion';
import RegInstructuionDetail from './reg-instructuion-detail';
import RegInstructuionUpdate from './reg-instructuion-update';
import RegInstructuionDeleteDialog from './reg-instructuion-delete-dialog';

const RegInstructuionRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<RegInstructuion />} />
    <Route path="new" element={<RegInstructuionUpdate />} />
    <Route path=":id">
      <Route index element={<RegInstructuionDetail />} />
      <Route path="edit" element={<RegInstructuionUpdate />} />
      <Route path="delete" element={<RegInstructuionDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default RegInstructuionRoutes;
